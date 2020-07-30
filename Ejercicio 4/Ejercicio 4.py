#!/bin/python3

import math
import os
import random
import re
import sys


def gridSearch(G, P):
    finalResolut = "NO"
    patternPossition = 0
    possitions = []
    possitionsBoolean = []
    
    #Go thru all the rows of the grid
    for rowGrid in G:
        if (patternPossition < len(P)):
          #Check if it has a specific line of the pattern
          if(P[patternPossition] in rowGrid):
            if(rowGrid.count(rowGrid[0]) != len(rowGrid)):
              possitions.append(rowGrid.find(P[patternPossition]))
            else:
              possitionsBoolean.append(True)
            patternPossition = patternPossition + 1
            
          else:
            patternPossition = 0
    
    #Gives the final answer
    if(len(possitions) > 0 and (len(possitions) + len(possitionsBoolean)) == len(P)):
      if(len(possitions) == 0):
        placeHolder = possitionsBoolean[0]
      else:
        placeHolder = possitions[0]
      for resoult in possitions:
        if(resoult == placeHolder):
          placeHolder = resoult
          finalResolut = "YES"
        else:
          finalResolut = "NO"

    return finalResolut

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(input())

    for t_itr in range(t):
        RC = input().split()

        R = int(RC[0])

        C = int(RC[1])

        G = []

        for _ in range(R):
            G_item = input()
            G.append(G_item)

        rc = input().split()

        r = int(rc[0])

        c = int(rc[1])

        P = []

        for _ in range(r):
            P_item = input()
            P.append(P_item)

        result = gridSearch(G, P)

        fptr.write(result + '\n')

    fptr.close()
