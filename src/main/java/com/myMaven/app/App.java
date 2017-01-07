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
    	DMatrix trainMat = new DMatrix("/home/stream/Desktop/stupidjava/mvn2017/HelloXgb4J/src/data/xgb.DMatrix.data");
    	System.out.println(trainMat.rowNum());

    	//load model produced by R
    	Booster booster2 = XGBoost.loadModel("/home/stream/Desktop/stupidjava/mvn2017/HelloXgb4J/src/data/xgb.model");
 
    	
    	//create a testing feature, test it  	
	    float[] data = new float[] {1f,2f,3f,4f,5f,6f,1f,2f,3f,4f,5f,6f,1f};
	    int nrow = 1;
	    int ncol = 13;
	    float missing = 0.0f;
	    DMatrix dmat = new DMatrix(data, nrow, ncol, missing);
	    float[][] predicts3 = booster2.predict(dmat);
	    for (int i = 0; i <15 ;  i++) {
	    	System.out.println(predicts3[0][i]);
	    }
	    
    	/*
	   //test trainMat is pass correctly 
    	float[][] predicts3 = booster2.predict(trainMat);
	    for (int i = 0; i <15 ;  i++) {
	    	System.out.println(predicts3[0][i]);
	    }*/
    }
}
