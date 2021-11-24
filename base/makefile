Admin.class: Admin.java User.java
	javac Admin.java

Hospital.class: Admin.java User.java Patient.java Date.java Hospital.java Doctor.java FrontDesk.java Nurse.java
	javac Admin.java User.java Patient.java Date.java Hospital.java Doctor.java FrontDesk.java Nurse.java

run: Hospital.class
	java Hospital

clean: 
	rm -f *.class

debug:
	jdb Main
