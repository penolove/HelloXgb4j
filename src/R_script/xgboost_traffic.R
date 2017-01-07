#this line is for Rscript execution
.libPaths( c( .libPaths(), "~/R/x86_64-redhat-linux-gnu-library/3.2") )

library(xgboost)
packageVersion("xgboost")
setwd("~/Desktop/stupidjava/mvn2017/HelloXgb4J/src/R_script")
load("LTEextreaction.rdata.RData")
remains<-names(which(table(x$label)>=50))
h1<-x$label %in% remains

x<-x[h1,]

x[,15]=factor(x[,15])
n_class=length(levels(x[,15]))

vali_idx=sample(nrow(x), nrow(x)*0.2)

train_x=as.matrix(sapply(x[-vali_idx,2:14], as.numeric))
train_y=as.integer(x[-vali_idx,15])-1

vali_x=as.matrix(sapply(x[vali_idx,2:14], as.numeric))
vali_y=as.integer(x[vali_idx,15])-1

dtrain<- xgb.DMatrix(train_x,label=(train_y))  
dval<- xgb.DMatrix(vali_x, label=(vali_y))  

param <- list(  objective           = "multi:softprob", 
                eta                 = 0.1 , # 0.06, #0.01,
                eval_metric         = "merror",
                max_depth           = 3, #changed from default of 15
                subsample           = 0.3, # 0.9
                num_class           = n_class
                
)
watchlist <- list(eval = dval,train=dtrain)


bst <- xgb.train(   params              = param, 
                    data                = dtrain, 
                    nrounds             = 1000, #300, #280, #125, #250, # changed from 300
                    verbose             = 1,
                    early_stopping_rounds    = 150,
                    watchlist           = watchlist
)

xgb.DMatrix.save(dtrain, '../data/xgb.DMatrix.data')
xgb.save(bst, '../data/xgb.model')


#check model
mat=c(1,2,3,4,5,6,1,2,3,4,5,6,1)
dtest <-xgb.DMatrix(matrix(mat,nrow=1))
pred0 = predict(bst,dtest)
pred0

#check data
#dtest <-xgb.DMatrix(matrix(train_x[1,],nrow=1))
#pred0 = predict(bst,dtest)
#pred0
#max(pred0)
