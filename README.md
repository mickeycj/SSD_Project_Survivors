# Survivors!
Survivors is a game in which the player's goal is to eat as many enemies as possible while trying to stay alive and making high scores.

## Rules/Features
- Your unit moves according to your mouse movements
- You can only eat smaller enemies
- Different levels of enemies
- More challeges are offered as player progresses through each levels

## Patterns and Principles
### Patterns
- Flyweight Pattern
-- In order to preserve performance when loading resources such as image files,
 the resources are pre-loaded before start of the game.
 - Strategy Pattern
 -- There are two types of units: Player and Enemy. Since both of them receive move commands differently, their classes are separated, extending from the same superclass.
 - Object Pool Pattern
 -- Since we know the maximum number of enemies that can be on-screen at any given time, preloading them prior to the start of the game will save some performance.

 ### Principles
 - Single Responsibility Principle
 -- We try to specialize each class as much as possible, spliting the program into many independent parts, such as Game, World, Player, Enemy, as well as the base classes.
 - Open/Closed Principle
 -- Since all untis may differ in their behaviors, they can be extended to create more variations. However, they all still follows the same general pattern specified by its superclass.
 - Polymorphism
 -- Each object behaves differently, but with the expected result from the variations of their methods' implementations.

 ## Members/Responsibilities
 - Nutcharueta Sihirunwong 5810545866
 -- Implement Enemy class
 -- Design and implement methods in World class
 -- Design and implement game's logic, such as leveling systems and formula for converting enemy level to its radius (Team effort)
 -- Design unit and background images (with Budnampetch)
 - Budnampetch Onmee 5810545947
 -- Implement Player class, especially mouse movements
 -- Design and implement the rendering of images, both for units and backgrounds.
 -- Design and implement game's logic (Team effort)
 -- Design unit and background images (with Nutcharueta)
 - Chanon Jenakom 5810546625
 -- Design and lay out the base classes
 -- Design and implement the mentioned patterns/principles
 -- Design and implement game's logic (Team effort)
 -- Add scoring system
 -- Refactor codes and fix bugs
