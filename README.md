# Impledge_question_repo
<B>Data structure Used :</B>
<br>
To store all inputs in dictionary type structure I use trie data structure so that I can get to know about words which are the part of current word
<br>
<B>Approach of finding longest:<br></B>
Read Input from file.<br>
Make Trie data structure and insert words in Trie<br>
Keeping the track of Longest and second longest word.<br>
then we are iterating over each input word and checking whether current word can be formed by concatening the other words of given input or not<br>
<B>Approach of finding time elapse:<br></B>
using inbuilt function of java currentTimeMillis() which give current execution time then by using this function in starting and in ending we can find out the time gap which result total execution time of our project.
<BR><BR><BR><B>Subapproach with code description</B>
<UL><LI><i>I created findLongestCompoundWords Method</i>i>
<LI>To keep track of longest and second longest compounded word 
<LI>for this it call isCompoundWord Method that tells whether word is compounded or not if yes then it checks whether we have word which larger then that word if not then replace that word with larger compounded word
</UL>
<UL><LI><i>I created isCompoundWord Method</i>
<LI>To check each word whether is compounded or not. 
 <LI> iT accepts trie , word and starting index 
<LI>it iterate over each letter of word from starting index and checks if there is a child node for the current character in the trie and also it is not last one if it false then word cant form so it return false if yes then it call isCompoundWord Method recursiveley to check further sub letters of same word.
</UL>
