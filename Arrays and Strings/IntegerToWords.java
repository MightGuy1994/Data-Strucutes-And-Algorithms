class IntegerToWords {
    public String numberToWords(int num) {

        if(num == 0){
            return "Zero";
        }


        int billion = num/(1000000000);
        int million = (num - billion * 1000000000 )/1000000;
        int thousand = (num-billion * 1000000000- million * 1000000)/1000;
        int rest = num-billion * 1000000000-million * 1000000-thousand *1000;
        String res = "";

        if(billion != 0){
            res = three(billion) + " Billion";
        }
        if(million != 0){
            if(res.length() != 0){
                res += " "+three(million)+" Million";
            }
            else{
                res = three(million)+" Million";
            }
        }
        if(thousand!=0){
            if(res.length() != 0){
                res += " "+three(thousand)+" Thousand";
            }
            else{
                res = three(thousand)+" Thousand";
            }
        }

        if(rest!=0){
            if(res.length() != 0){
                res += " "+three(rest);
            }
            else{
                res = three(rest);
            }
        }
        return res;
    }

    public String three(int num){

        int hundred = num/100;
        int rest = num - hundred *100;
        String res = "";
        if(hundred * rest != 0){
            res = one(hundred) + " Hundred " + two(rest);
        }
        else if(hundred == 0 && rest != 0){
            res = two(rest);
        }
        else if(hundred !=0 && rest == 0) {
            res = one(hundred) + " Hundred";
        }
        return res;
    }

    public String two(int num){
        if(num == 0)
            return "";
        String res = "";
        if(num <10){
            res = one(num);
        }
        else if(num < 20){
            res = lessThanTwenty(num);
        }
        else {
            int tenner = num/10;
            int rest = num - tenner*10;
            if(rest != 0){
                res = ten(tenner)+ " "+ one(rest);
            }
            else{
                res = ten(tenner);
            }
        }
        return res;
    }

    public String ten(int num){
        switch(num) {
            case 2: return "Twenty";
            case 3: return "Thirty";
            case 4: return "Forty";
            case 5: return "Fifty";
            case 6: return "Sixty";
            case 7: return "Seventy";
            case 8: return "Eighty";
            case 9: return "Ninety";
        }
        return "";
    }

    public String lessThanTwenty(int num){
        switch(num) {
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
        }
        return "";
    }

    public String one(int num){
        switch(num) {
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
        }
        return "";
    }
}

// divide and conquer logic. we divide number up to max of three digits. (billion,million, thousand, rest)/
// next pass each three digit to print their words.
