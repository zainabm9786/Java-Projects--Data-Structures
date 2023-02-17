public class STQA {
    // incomeList[]: the array recording the individual income items
// childList[]: the array recording the ages of children supported by this person

    // parentList[]: the array recording the ages of parents supported by this person
    public double computeTax(double[] incomeList, int[] parentList, int[] childList) {//method
        double taxAmount = 0.0;
        double incomeAmount = 0.0;


// calculate the income amount

        for (int i = 0; i < incomeList.length; i++) {
            incomeAmount = incomeAmount + incomeList[i];
        }
// calculate the basic tax
        if (incomeAmount <= 40000) {//less than 40,000
            taxAmount = incomeAmount * 0.02;
        } else if (incomeAmount > 40000 && incomeAmount <= 80000) {//income b/w 40,000 and 80,000
            taxAmount = 800 + incomeAmount * 0.07;
        } else if (incomeAmount > 80000 && incomeAmount <= 120000) {//greater than 80,000 and less 120,000
            taxAmount = 800 + 2800 + incomeAmount * 0.12;
        } else if (incomeAmount > 120000) {//income greater than 120,000
            taxAmount = 800 + 2800 + 4800 + incomeAmount * 0.17;
        }
// calculate the tax exemption from having children

        int taxExemption = 0;
        int numOfChild = childList.length;
        while (numOfChild > 0) {//if have chidlren
            if (childList[numOfChild - 1] < 18) {//if child is less than 18 years old
                taxAmount = taxAmount - 4000;
                taxExemption = taxExemption + 4000;
            }
            numOfChild--;
        }

// calculate the tax exemption from having parents
        for (int j = 0; j < parentList.length; j++) {//if have parents
            if (parentList[j] > 60) {//if part is over 60 years
                taxAmount = taxAmount - 2000;
                taxExemption = taxExemption + 2000;
            }
        }
// the maximum tax exemption is 8000 each person

        if (taxExemption <= 8000) {//if tex expenpoin is less than 8000
            if (taxAmount >= 0) {//if tax is more than 0
                return taxAmount;////////////////////////////////////////////////HERE
            } else { // i.e., taxAmount is 0
                return 0;
            }
        } else { // i.e., taxExemption > 8000     HEREEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
            taxAmount = taxAmount + (taxExemption - 8000);//if tax expemtion is more tham 8000
            return taxAmount;
        }
    }
}





