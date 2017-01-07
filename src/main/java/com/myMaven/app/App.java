package com.myMaven.app;

import java.io.File;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ml.dmlc.xgboost4j.java.Booster;
import ml.dmlc.xgboost4j.java.DMatrix;
import ml.dmlc.xgboost4j.java.XGBoost;
import ml.dmlc.xgboost4j.java.XGBoostError;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws XGBoostError
    {		
    	/*
    	Booster booster2 = XGBoost.loadModel("/home/stream/Desktop/stupidjava/mvn2017/HelloXgb4J/src/data/xgb.model");

	    float[] data = new float[] {1f,2f,3f,4f,5f,6f,1f,2f,3f,4f,5f,6f,1f};
	    int nrow = 1;
	    int ncol = 13;
	    float missing = 0.0f;
	    DMatrix dmat = new DMatrix(data, nrow, ncol, missing);
	    float[][] predicts3 = booster2.predict(dmat);
	    for (int i = 0; i <15 ;  i++) {
	    System.out.println(predicts3[0][i]);
	    }*/
    	 DMatrix trainMat = new DMatrix("/home/stream/Desktop/stupidjava/mvn2017/HelloXgb4J/src/data/xgb.DMatrix.data");
    	/*
    	    DMatrix trainMat = new DMatrix("/home/stream/Desktop/stupidjava/mvn2017/HelloXgb4J/src/data/agaricus.txt.train");
    	    DMatrix testMat = new DMatrix("/home/stream/Desktop/stupidjava/mvn2017/HelloXgb4J/src/data/agaricus.txt.test");
    
    	    trainMat.rowNum();
    	    System.out.println(trainMat.rowNum());
    	    HashMap<String, Object> params = new HashMap<String, Object>();
    	    params.put("eta", 1.0);
    	    params.put("max_depth", 2);
    	    params.put("silent", 0);
    	    params.put("objective", "binary:logistic");
			
    	    HashMap<String, DMatrix> watches = new HashMap<String, DMatrix>();
    	    watches.put("train", trainMat);
    	    watches.put("test", testMat);

    	    //set round
    	    int round = 2;

    	    //train a boost model
    	    Booster booster = XGBoost.train(trainMat, params, round, watches, null, null);

    	    //predict
    	    float[][] predicts = booster.predict(testMat);

    	    //save model to modelPath
    	    File file = new File("./model");
    	    if (!file.exists()) {
    	      file.mkdirs();
    	    }

    	    String modelPath = "./model/xgb.model";
    	    booster.saveModel(modelPath);
			*/
    }
}
