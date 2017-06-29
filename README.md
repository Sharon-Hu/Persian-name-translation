# Persian-name-translation
This project is to use machine learning algorithms to translate persian names to english names.

This is the direction how to use the system.

1. Use Global Edit Distance when r parameter is the same for all replacements
   Compile and run class MethodDemoGlobal and the matching names will be shown in resultGlobal.txt

2. Use Global Edit Distance when r parameters are modified
   Compile and run class MethodDemoImproveGlobal and the matching names will be shown in resultImproveGlo.txt

3. Evaluate the two systems
   Compile and run class Test. Note that test can only be run after resultGlobal.txt and resultImproveGlo.txt are retrieved.

Other classes:
CalMat: To calculate occurrence of replacement pairs
GlobalEditDistance: To calculate Global Edit Distance between two names when r parameter is the same
ImproveGlo: To calculate Global Edit Distance between two names when r parameters are modified
LocalEdiDis: To get the best match substrings between names
Eva recall: To evaluate performance

