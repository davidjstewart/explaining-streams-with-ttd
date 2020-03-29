# explaining-streams-with-ttd
Another example of using ttd to recreate and explain modern programming features (...and maybe some old features along the way).

## Original Ambition of this Kata
This exercise is implemented in Java and will recreate stream functions such as map, filter and reduce.

I chose to use Java for this exercise because the equivalent JavaScript functions are simply too easy to recreate.

## Route Travelled in Reality
The original ambition was to understand how Java Streams work internally using TDD to recreate some of the functional high order implementations (e.g. map, filter, etc). After some reading the method of how Streams iterate through a collection became the subject of this exercise.

_"Please remember, Streams are not data containers and streams do not contain any data. You may think streams as fancy iterator and data just pass through that. This is analogous to an old iterator." - [basicstrong.com](https://basicsstrong.com/creating-your-own-streams-using-custom-spliterator-and-how-streams-works-internally-in-java/)_
