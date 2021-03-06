akka_example
============

This is a pretty simple example of using actors in Akka.
The system consists of two actors. The first generates 
random events every few seconds, and the second processes
these events by printing them. 

If you don't have scala, SBT and Akka installed, you 
don't really need them for this example, as all libraries
are included. You do need scalac in order to compile the code. 

NOTE: This was written in Scala 2.9.2. In Scala 2.10, Akka is included by default, so the jars aren't necessary.

## Downloading

To check out the repo, do 

	git clone https://github.com/joshuaar/akka_example

## Compiling

To compile, do 

	scalac -cp "akka-actor-2.0.5.jar:config-0.3.1.jar" akka_example.scala

This works under Linux. Under Windows you might need to use ; instead of : for the classpath separator

## Running

To run, do

	java -cp "scala-library.jar:akka-actor-2.0.5.jar:config-0.3.1.jar:." akka.SendRcvExample.SendReceiveTest

You should get output that looks like this:

	Starting
	sender is sending msg
	POST:Post something
	sender is sending msg
	POST:Post something
	sender is sending msg
	POST:Post something else
	sender is sending msg
	GET: Get something
	sender is sending msg
	POST:Post something else
	sender is sending msg
	POST:Post something else
	sender is sending msg
	POST:Post something
	...

##Summary
This example uses Akka and Scala to send messages between two actors.
The Sender actor recieves a START message, which prompts it to choose
a random message and send it to the Receiver. Receiver then prints 
the message to the screen and sends a START message back to the
sender, repeating the process.


