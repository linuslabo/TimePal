# TimePal
A minimal humble Java 8 library to handle more comfortably the most common usages of java.time API.

For more info on java.time API, see [the official docs](http://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html "Java Time API").

## Requirements
JDK 1.8+.

## Configuration
Default ZoneOffset is `ZoneOffset.UTC` and default formatter is the `DateTimeFormatter.ISO_LOCAL_DATE_TIME` (e.g. 2011-12-03T10:15:30).

A standard formatter and the UTC offset (when needed) are strongly recommended.

Most of methods accept ZoneOffset and/or DateTimeFormatter as arguments.
If you really need to change the defaults values, you can make your own TimePal build and update the static initializer of the `TimePal` class:

	static {
		/* Setting defaults */
		DEFAULT_ZONE_OFFSET = ZoneOffset.UTC;
		DEFAULT_DATE_TIME_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
	}

## Usage
### Maven
If you use maven. add the TimePal dependency to your project:

	<dependency>
		<groupId>net.cascone.utils</groupId>
		<artifactId>time-pal</artifactId>
		<version>1.0-SNAPSHOT</version>
	</dependency>

You may need to `git clone` and `mvn install` the project in your local repo, or upload it to some centralized repo manager (i.e. Artifactory, Nexus,...).

### Classpath
Compile the project and add the `time-pal-*version*.jar` file to your project's classpath.

### Copy
Feel free to copy and paste any part of this repo in your code.



## Contributing
1. Fork it!
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin my-new-feature`
5. Submit a pull request :D


## History
**1.0-SNAPSHOT** first public snapshot.


## License
TimePal is under MIT License (see LICENSE.md).