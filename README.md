akka_example
============

This is a pretty simple example of using actors in Akka.
The system consists of two actors. The first generates 
random events every few seconds, and the second processes
these events by printing them to the stdout.

## Installing

To check out the repo, do 

	git clone https://github.com/joshuaar/akka_example

## Running

To run the server, do 

	go run ./server.go
