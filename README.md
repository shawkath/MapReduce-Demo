# MapReduce-Demo
A Demo MapReduce program to process a small amount of data 

# HOW TO:

1. Compile the project by updating maven dependencies 
2. Export as .jar from eclipse by pointing the main method class (Students.java)
3. Load the input data to HDFS
    COMMAND TO LOAD THE INPUT DATA TO HDFS: 
    
4.Execute the job using the jar and provide arugements (input & output filepaths) 
    COMMAND TO EXECUTE THE MAPREDUCE JOB: 
    hadoop jar students-high-mark.jar hdfs:/new-students.txt hdfs:/student-out9.txt
5. Verify the output files
    COMMAND TO VERIFY THE OUTPUT:
    hadoop fs -cat hdfs/student-out9.txt/part-r-000001
    hadoop fs -cat hdfs/student-out9.txt/part-r-000002
    hadoop fs -cat hdfs/student-out9.txt/part-r-000003
                        OR 
View the output through the HDFS user interface:
http://<YOUR_IP>:50075/browseDirectory.jsp?dir=/student-out9.txt&namenodeInfoPort=50070&nnaddr=<YOUR_IP>:8020

INPUT DATA: 
Marks of 5 students of their five subjects for 3 semesters. 

John, 76, 56, 89, 90, 55
Hari, 25, 76, 56, 89, 99
Shehnaz, 56, 56, 89, 91, 89
Tina, 46, 89, 90, 55, 60
Suhana, 60, 55, 60, 89, 96
John, 45, 89, 90, 55, 60
Hari, 50, 89, 93, 55, 56
Shehnaz, 56, 89, 55, 60, 89
Tina, 56, 56, 89, 91, 55
Suhana,  89, 90, 55, 60,60
John, 60, 55, 45, 89, 91
Hari, 45, 44, 66, 55, 60
Shehnaz,  89, 90, 55, 60,60
Tina, 76, 76, 56, 89,55
Suhana, 25, 76, 56, 89, 99


OUTPUT DATA:
Mining the top scored marks out of all the subjects & semesters

John	91
Suhana	99
Tina	91
Hari	99
Shehnaz	91
