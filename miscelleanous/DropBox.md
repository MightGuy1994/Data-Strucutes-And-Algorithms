# Drop Box Design

## Component Design


### Client
	Upload/download files
	Detect file changes
	Handling conflicts due to offline/ cocurrent

#### Files transfer efficiently
	Break each file to small chunks usually 4MB. it mainly depends on the network bandwidth, storage system, read/writes per second. each metadata about the file should consists of
	chunks information
	
