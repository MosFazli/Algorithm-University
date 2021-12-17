using System;

class BinDivideConquerAlgorithm
{
 
static int DAC_Max(int []a, int index, int l)
{
    int max;
     
    if (index >= l - 2)
    {
        if (a[index] > a[index + 1])
            return a[index];
        else
            return a[index + 1];
    }

    max = DAC_Max(a, index + 1, l);
 
    if (a[index] > max)
        return a[index];
    else
        return max;
}
 
static int DAC_Min(int []a, int index, int l)
{
    int min;
    if (index >= l - 2)
    {
        if (a[index] < a[index + 1])
            return a[index];
        else
            return a[index + 1];
    }
 

    min = DAC_Min(a, index + 1, l);
 
    if (a[index] < min)
        return a[index];
    else
        return min;
}
 
}