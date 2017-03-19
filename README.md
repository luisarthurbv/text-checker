# A simple char stream library

**text-checker** is a library that process char streams.

## firstChar

**firstChar** is a method that returns a char from a stream.
The char returned is a vocal (that doesn't appear more in the rest of the stream), 
which is preceded by a consoant, which is preceded by a vocal.

If no char with this conditions is found, an exception will be thrown.