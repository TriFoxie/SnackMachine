# Snack Machine
*ItM Coursework: Snack bar simulation.*

## Usage
1) Extract the [latest version](https://github.com/trifoxie/snackmachine/releases/latest) and go to the extracted files folder.
```
cd <extracted-files-location>
```
2) Run SnackBar with any optional arguments.
```
java SnackBar <nSteps> <nStudents> <nPackets> <cost>
```

### Arguments
No arguments are required, however all arguments up to the right-most one you need are.
| Argument | Type | Description | Default |
| - | - | - | - |
| nSteps | int | The amount of steps to run the simulation for. | 150 |
| nStudents | int | The amount of students to include in the simulation. | 10 |
| nPackets | int | The amount of packets to include in the snack machine. | 10 |
| cost | int | The cost of an individual crisp packet in pennies. | 2 |

### Example:
```
java SnackBar 100 20 50 2
```
