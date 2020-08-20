class VersionControl {
    public int compareVersion(String version1, String version2) {

        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int i =0, j = 0;

        while(i < v1.length || j < v2.length){

            int a = (i >= v1.length)? 0 : Integer.valueOf(v1[i]);
            int b = (j >= v2.length)? 0 : Integer.valueOf(v2[i]);

            if(a<b) return -1;
            else if (a>b) return 1;

            i++;
            j++;
        }
        return 0;
    }
}

//time complexity O(max(v1,v2)
// space complexity = O(1)
// intutiion. just split on "." and conpare two digits. if either of one is greater or lesser, return