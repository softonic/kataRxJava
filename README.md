kataRxJava
======

This repo a simple project with three diferent exercises. Each exercise has its own tests specified. There are also to branches:
- *master:* full source code with the sugested solutions.
- *kata:* full source code with some TODO comments with details about to be implemented there.

Try to solve all the exercises of the *kata* branch and after that compare your solution with the one in the *master* branch.

Each exercise is described in the following sections.

Hanoi Towers
------
This is the famous problem of moving a set of disks with diferent sizes from one source pole to a destination pole using an auxiliar pole. The only one restriction applied is that it could be never a situation wether a disk A larger than a disk B sitting above disk B. More details of the problem here: https://en.wikipedia.org/wiki/Tower_of_Hanoi

The main goal is to solve this problem using RxJava.

Consensus
------

In this exercise you have 3 different voters that should randomly emit a boolean response. Each voter has a max time of 1s to give his answer. After that time, a resolution should be emitted, just picking the most voted response. Each voter will write its answer in a journal. The final resolution will also been written into the journal.

Take a look at the comments and follow them and give a solution using RxJava.

Random Family
------
Take a look at the Random User API. It's just an API that allows you to create random users. The goal of this exercise is just create a new service for creating random families, where a family is composed by:

- A father.
- A mother.
- An arbitrary list of sons.
- An arbitrary list of daughters.

Keep in mind to follow the Anglo-saxon tradition for naming conventions related to the last name of each one of the members of the family.

General Suggestion
------
As RxJava is mostly used in environments driven by events, and the proposed exercises follows an imperative paradigm, I suggest you to avoid using ``Subscriber``'s and use the ``toBlocking`` method, allowing to execute any given observable composition inplace, as shown in the bellow code:

`````java
Observable<Integer> obs = Observable
    .range(0, 10)
    .map(...);
List<Integer> result = obs
    .toList()     // Required only when result should be a list.
    .toBlocking()
    .first();
`````
