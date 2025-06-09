# Assignment Instructions - Lempel-Ziv-Welch Compression
Write a program that uses LZW compression to compress and decompress text. In this case, the text will just be the letters A,C,G,T. This is to simulate compressing and decompressing DNA information coded as a sequence of nucleotides.

For reference you can use our lesson recording and also check out the Wikipedia article on LZW.

## Requirements:

It should support compression and (lossless) decompression using LZW technique.
It should only consider the letters ACGT.
For consistency in the encoding and decoding, initially you should start with the following values in your dictionary A=0, C=1,G=2, T=3.
It is not processing files but just input text. See the example run below.
## Compressing:
**Input:** The text to compress will just be a string of letters, one line. E.g. ACGCGCGTACGCGTA
<br> **Output:** The index values for each compressed pattern found, as described in the article and discussed in class. These will be separated by spaces. E.g.: 0 1 2 5 5 3 4 6 2 9
## Decompressing: (Essentially the reverse)
**Input:** The index values for each compressed pattern separated by spaces. E.g: 0 1 2 5 5 3 4 6 2 9
**<br>Output:** The uncompressed text which should be a single line of letters. E.g: ACGCGCGTACGCGTA
## Additional Notes:

You can either have two different programs - one for compression and one for decompression - or a single program that takes an argument (or asks for input) on deciding which operation to perform.
Include clear instructions (in the header comments of your code) on how to run the program to both compress and decompress.
You are not writing these at the byte level. It would be important for actual file compression/decompression but this is just to make it easier to test the LZW implementation.
## Here is an example run:
```
PS C:\Users\caduncan\Projects\LZW> python .\lzw.py
C
ACGCGCGTACGCGTA
0 1 2 5 5 3 4 6 2 9
```
```
PS C:\Users\caduncan\Projects\LZW> python .\lzw.py
D
0 1 2 5 5 3 4 6 2 9
ACGCGCGTACGCGTA
```
This is an S skill. It is not necessary to complete this to pass the class but it does raise your overall grade.