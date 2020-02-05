# -*- coding: utf-8 -*-
"""
Created on Wed Feb  5 16:00:08 2020

@author: Hitesh
"""

import pandas as pd
import numpy as np

def readcsv(filename):
    #read the csv using inbuilt pandas function
    data = pd.read_csv(filename)
    #returning the array
    return(np.array(data)) 

def print1(arr):  
    # number of arrays 
    n = len(arr) 
    # to keep track of next element  
    # in each of the n arrays 
    indices = [0 for i in range(n)] 
    while (1): 
        # prcurrent combination 
        for i in range(n): 
            print(arr[i][indices[i]], end = "") 
        print(end = ", ")
        # find the rightmost array that has more 
        # elements left after the current element 
        # in that array 
        next = n - 1
        while (next >= 0 and 
              (indices[next] + 1 >= len(arr[next]))): 
            next-=1
        # no such array is found so no more 
        # combinations left 
        if (next < 0): 
            return
        # if found move to next element in that 
        # array 
        indices[next] += 1
        # for all arrays to the right of this 
        # array current index again points to 
        # first element 
        for i in range(next + 1, n): 
            indices[i] = 0
#C:\Users\Hitesh\Documents\input.csv
i = input()
arr = readcsv(i)
#calling print1 function to print the permutation
print1(arr)