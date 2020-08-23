package com.etl;

public class FilesMerge {
    private String fileLocation;
    private String outputFileName;

    public FilesMerge(){}

    public void mergeFiles(String fileLocation,String outputFileName) throws Exception {
        if(fileLocation.length() == 0)
            throw new Exception("File Location Not Found");
        if(outputFileName.length() == 0)
            throw new Exception("Output FileName Not Found");

        

    }


}
