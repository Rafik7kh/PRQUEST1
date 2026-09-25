## How to Compile and Run (command line)

From inside the folder that contains `src/`:

```
cd PRQuest/src
javac *.java
java Main
```

1. Right-click `Main.java` in the Package Explorer.
2. Select **Run As > Java Application**.
3. Type commands into the Console view at the bottom.

## How to Run the Tests

1. Right-click the `test` folder in the Package Explorer.
2. Select **Run As > JUnit Test**.
3. Results (pass/fail) appear in the JUnit view.

## Commands

| Command | Description |

| `START WORKOUT` | Begin a new workout session |
| `ADD EXERCISE <name>` | Add an exercise to the active session |
| `LOG SET <weight> <reps>` | Log a set for the most recently added exercise |
| `CHECK PR <exercise>` | Show the historical personal best for an exercise |
| `SUMMARY` | Show exercises and sets logged so far in the session |
| `FINISH WORKOUT` | End the session and save it to history |
| `HELP` | Show the list of commands |
| `QUIT` | Exit the program |

