# SLF4J and Logback tutorials

Eight small Java programs introduce SLF4J logging and Logback configuration. The examples are intentionally independent entry points: run one `ApplicationN` class at a time.

| Example | Topic | Configuration |
| --- | --- | --- |
| Application1 | TRACE through ERROR; parameterized messages and exception logging | Logback default |
| Application2 | Inspect Logback's internal status | Logback default |
| Application3 | Compare eager concatenation with SLF4J placeholders | Logback default |
| Application4 | Load a root level and console appender from the classpath | `src/logback.xml` |
| Application5 | Replace the active configuration programmatically | `sample5.xml` (ERROR only) |
| Application6 | Write to both console and a file | `sample6.xml` |
| Application7 | Rotate a file by day and size | `sample7.xml` |
| Application8 | Demonstrate a rolling file and optional email appender | `sample8.xml` |

## Requirements

- A JDK with `javac` and `java`
- The bundled `lib/*.jar` dependencies (SLF4J 1.6.1, Logback 0.9.28, and mail libraries)

This is a legacy teaching project. Its bundled dependencies are old; use current supported versions in production applications. The included JARs are third-party artifacts and are not covered by this repository's MIT license.

## Compile and run

Run these commands from the repository root. On macOS or Linux:

```sh
mkdir -p .build/classes
javac -cp "lib/*" -d .build/classes $(find src -name '*.java')
java -cp ".build/classes:lib/*" com.waheed.tutorial1.Application1
java -cp ".build/classes:lib/*" com.waheed.tutorial2.Application2
java -cp ".build/classes:lib/*" com.waheed.tutorial3.Application3
```

Without `src` on the runtime classpath, examples 1–3 use Logback's default console configuration. DEBUG and higher are visible; TRACE is suppressed. To run example 4, copy its configuration into the compiled classpath:

```sh
cp src/logback.xml .build/classes/
java -cp ".build/classes:lib/*" com.waheed.tutorial4.Application4
```

Examples 5–8 load their `sampleN.xml` files from the current working directory, replacing any configuration already loaded. For example:

```sh
java -cp ".build/classes:lib/*" com.waheed.tutorial5.Application5
java -cp ".build/classes:lib/*" com.waheed.tutorial6.Application6
java -cp ".build/classes:lib/*" com.waheed.tutorial7.Application7
java -cp ".build/classes:lib/*" com.waheed.tutorial8.Application8
```

On Windows, use `;` instead of `:` between classpath entries. In PowerShell, compile source files with `javac -cp "lib/*" -d .build/classes (Get-ChildItem src -Recurse -Filter *.java).FullName`; create the output directory first with `New-Item -ItemType Directory -Force .build/classes`. Example 4 also requires copying `src/logback.xml` to `.build/classes`.

You can also import the existing Eclipse project. The committed `bin/` classes reflect an older build; compile the `src/` sources to see these improvements.

## Email example

`sample8.xml` defines an SMTP appender but does **not** attach it to the root logger by default. To try it, set the SMTP host, account, sender and recipient in a *local* copy of the XML, then uncomment its `EMAIL` appender reference. Do not commit real credentials. Example 8 writes a local log file even when email delivery is disabled.

File and rolling-file examples create logs in the repository root. They are ignored by Git.

## License

The repository's original source code and documentation are available under the [MIT License](LICENSE). Bundled JARs remain under their respective upstream licenses.
