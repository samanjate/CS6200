---------------------

 * Introduction
    These programs were developed using python:
    2.7.12 (v2.7.12:d33e0cf91556, Jun 26 2016, 12:10:39)
      [GCC 4.2.1 (Apple Inc. build 5666) (dot 3)]
    Java version 8.0
    Lucene version 4.7.2


 * Requirements
    Task 1 requires three Lucene 4.7.2 jar files that has been provided in the 
    Task 1 -> Source Code folder

 * Running the program
    To run the python program, please copy paste the .py files in the working
    directory of your python IDLE and use commands as follows :

    Task 1: Import the java project LuceneSE. add reference to the given jar files.
            (please replace the given line of code, according to the local system.)

     temp = temp.replace("/Users/samanjatesood/Desktop/IR/IR-samanjate-assignment4/Task 2/      Tokenized pages/", "");

            The program then asks for inputs. We can run the code on the tokenised pages   
            that is given in the Task 2 folder.

	    The java program gives the page rank score with the page names.
            The output given are run on the 4 queries given in the question.
            The python scripts (DocstoDocIDs.py) then takes this output and replaces the        
            page names to document IDs as given in the document to document IDs map in 
            Docs.txt file. Thus keep the ‘Docs.txt’ and the output of the java program 
            in the current directory of python IDLE.
  
            run command: execfile('DocstoDocIDs.py')
         
      

    Task 2: execfile('Indexer.py')
            execfile('Retrival_Module.py')
	    The indexer will take the tokenised pages as input and the give the 
            inverted_index.txt and Docs.txt as output. 
            The retrieval module then takes inverted_index.txt and query.txt as input 
            and gives the four tables as output.


