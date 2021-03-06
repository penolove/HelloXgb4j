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
    	//load Dmatrix produced by R		
    	DMatrix trainMat = new DMatrix("src/data/xgb.DMatrix.data");
    	System.out.println(trainMat.rowNum());

    	//load model produced by R
    	Booster booster2 = XGBoost.loadModel("src/data/xgb.model");
 
    	
    	//create a testing feature, test it
		float[] data = new float[] {678f,928f,1448f,1448f,1448f,8f,104f,112f,61366f,14872f,154008f,443f,51319f};
	    int nrow = 1;
	    int ncol = 13;
	    float missing = 0.0f;
	    DMatrix dmat = new DMatrix(data, nrow, ncol, missing);
	    float[][] predicts3 = booster2.predict(dmat);
        long startTime = System.currentTimeMillis();
	    for (int i = 0; i <500000 ;  i++) {
	        predicts3 = booster2.predict(dmat);
	    }
	    long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        
        System.out.println("it takes : "+Long.toString(totalTime/1000)+" secs for 500000 records ");
    	/*
	   //test trainMat is pass correctly 
    	float[][] predicts3 = booster2.predict(trainMat);
	    for (int i = 0; i <15 ;  i++) {
	    	System.out.println(predicts3[0][i]);
	    }*/
    }
}
