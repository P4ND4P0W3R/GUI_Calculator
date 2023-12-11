# GUI_Calcultor

## <ins>*While using the calculator, you might notice, the buttons</ins> `0`, `+` <ins>and</ins> `=` <ins>being pressed by themselves, it is done to assure the proper working of the calculator (it is hard coded into the</ins> `CalculatorGUI.java` <ins>file)*</ins>

To run a Java program in the terminal, you need to follow these steps:

## 1. Install Java SE 17

Make sure you have Java SE 17 installed on your system. You can download it from the official Oracle website or use a package manager if you're on a Unix-based system.

## 2. Set up Java Environment Variables (if not done)

Ensure that your `JAVA_HOME` environment variable is set to the directory where Java is installed, and the `bin` directory is added to your system's `PATH`. This step is essential for the terminal to recognize Java commands.

## 3. Compile the Java Program

Open the terminal, navigate to the directory where your Java file is located, and compile it using the `javac` command:

```bash
javac Main.java
```

This will generate some `.class` file (`Main.class`, `CalculatorGUI.class`, `ButtonClickListener.class`).

## 4. Run the Java Program

Now, use the `java` command to execute the compiled program:

```bash
java Main
```

This should open a new window with the GUI Calculator.

Note: If you are using a more recent version of Java, you may need to use the `javac --enable-preview` option for compiling if your code uses preview features. Additionally, ensure that your Java program does not have any compilation errors before running it.
