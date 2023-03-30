# Athello

AI Genetic Algorithm Othello Engine

## Introduction

The **Athello** engine is an *Othello* (*Reversi*) game engine, which is built on the JAmuna genetic algorithm library.
The engine also uses the **OpenCSV** library for some CSV reading/writing tasks. The engine is trained on hundreds and
thousands of *Reversi* positions which are labeled for what is the best move in the position. The AI engine then starts
to recognize the patterns found in the game until the AI reaches a strong playing level. The AI can only view the position
from either white or black's perspective depending on the data that it is given. For our training set we use data from white's
perspective; however, you can train the engine using data from black's perspective if you wish.

## Installation

To use this engine, you can simply download the code from this repository and use it in your projects as needed.
The engine will download as a ```.zip``` file, which you can then extract into your desired location. The engine
runs fairly quickly and we will be constantly making updates to the engine's playing ability by training it on more
and more data. The hope is that the engine will reach a super-human level of playing ability. For more detailed information,
you can take a look at the code inside of the repository. This engine is a test bed for what JAmuna can do in a fairly
complicated task situation, even for a human.
