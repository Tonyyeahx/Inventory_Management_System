# Smart Stock Chipmunk Coding Standard Document

## GitLab


### Branches

- Choose short and descriptive branch names:

    ```
    # good
    $ git checkout -b oauth-migration

    # bad - too vague
    $ git checkout -b login_fix
    ```

- Identifiers from corresponding tickets in GitLab are also good candidates for use in branch names. For example:

    ```
    # GitLab issue #15
    $ git checkout -b issue-15
    ```

- Use first and last name initial for personal branches, followed by a slash and the name of the branch

    ```
    # For example, branch for Yucheng Zang:
    $ git checkout -b yz/feature-1
    ```

- Use lowercase and hyphens in branch names:
    ```
    $ git checkout -b new-feature      # good
    $ git checkout -b T321-new-feature # good (Phabricator task id)
    $ git checkout -b New_Feature      # bad
    ```


### Commits

- Each commit should be a single logical change. Don't make several logical changes in one commit. For example, if a patch fixes a bug and optimizes the performance of a feature, split it into two separate commits.

- Commit early and often. Small, self-contained commits are easier to understand and revert when something goes wrong.

- Commits should be ordered logically. For example, if commit X depends on changes done in commit Y, then commit Y should come before commit X.


### Commit Messages

- Avoid one-liner commit messages. Use the editor (such as Vim or VSCode), not just the terminal, when writing a commit message:

    ```
    # good
    $ git commit

    # bad
    $ git commit -m "Quick fix"
    ```

- The summary line (ie. the first line of the message) should be descriptive yet succinct, with a descriptive tag (see the section below). Ideally, it should be no longer than 50 characters. It should be capitalized and written in imperative present tense. It should not end with a period since it is effectively the commit title:

    ```
    # good - imperative present tense, capitalized, fewer than 50 characters
    FIX: Mark Huge Records as Obsolete When Clearing Hinting Faults

    # bad
    fixed ActiveModel::Errors deprecation messages failing when AR was used outside of Rails.
    ```

 - The commit message summary line should begin with one of the following tags, in all capital, followed by a colon:

    | Tag       | Explanation | 
    | --------- | ----------- |
    | BUILD     | Changes that affect the build system or external dependencies |
    | CI        | Changes to our CI configuration files and scripts |
    | CHORE     | Miscellaneous changes that do not fall under any of the other types, such as changes to meta information in the repo (owner files, editor config, etc) or licensing |
    | DOCS      | Documentation only changes |
    | EXAMPLES  | Additions or changes to the examples provided in the project’s examples/ folder |
    | FEAT      | A new feature |
    | FIX       | A bug fix |
    | PERF      | A code change that improves performance |
    | REFACTOR  | A code change that neither fixes a bug nor adds a feature |
    | REVERT    | A change that råeverses the change in earlier commit |
    | STYLE     | Changes that do not affect the meaning of the code (white-space, formatting, missing semi-colons, etc)
    | TEST      | Adding missing tests or correcting existing tests


- After that should come a blank line followed by a more thorough description. It should be wrapped to 72 characters and explain why the change is needed, how it addresses the issue and what side-effects it might have. It should also provide any pointers to related resources (eg. link to the corresponding issue in a bug tracker):

    ```
    Short (50 chars or fewer) summary of changes

    More detailed explanatory text, if necessary. Wrap it to
    72 characters. In some contexts, the first
    line is treated as the subject of an email and the rest of
    the text as the body.  The blank line separating the
    summary from the body is critical (unless you omit the body
    entirely); tools like rebase can get confused if you run
    the two together.

    Further paragraphs come after blank lines.

    - Bullet points are okay, too

    - Use a hyphen or an asterisk for the bullet,
    followed by a single space, with blank lines in
    between

    The pointers to your related resources can serve as a footer
    for your commit message. Here is an example that is referencing
    issues in a bug tracker:

    Resolves: #56, #78
    See also: #12, #34

    Source: http://tbaggery.com/2008/04/19/a-note-about-git-commit-messages.html
    ```


## Java 

### Highlight

- Block indentation: +2 spaces

- Indent continuation lines at least +4 spaces

- Column limit: 100

- Braces follow the Kernighan and Ritchie style ("Egyptian brackets")

- Use horizontal whitespace before ```(``` and after ```//```

- Use JavaDoc for at least public classes and public or protect members

- Use test driven development

- Use ```UpperCamelCase``` for class names, use ``` lowerCamelCase``` for method and variable names, and ```UPPER_SNAKE_CASE``` for constants


### Source File Basics


- The source file name consists of the case-sensitive name of the top-level class it contains (of which there is exactly one), plus the ```.java``` extension. 

    > For example, if the top-level class is ```public MyClass {...}```, the file name should be ```MyClass.java```

- Source files are encoded in UTF-8.

-  Exactly one top-level class declaration: 

    > Each top-level class resides in a source file of its own.

- The test class should be written piror to the production code. 

    - A test class has a name that ends with Test, for example, ```HashIntegrationTest```. If it covers a single class, its name is the name of that class plus Test, for example HashImplTest


### Import Statements

-  No wildcard imports: 
    
    > wildcard imports, static or otherwise, are not used.

- No line-wrapping: 
    
    > Import statements are not line-wrapped. The column limit (source code column limit: 100) does not apply to import statements.

### Formatting

- Naming:

    - Class names are written in ```UpperCamelCase```. 
    
    - Method names, non-constant field names, parameter, and local variable names are written in ```lowerCamelCase```.

    - Constant names use ```UPPER_SNAKE_CASE```: all uppercase letters, with each word separated from the next by a single underscore



- Use of braces:

    - Braces are used with ```if```, ```else```, ```for```, ```do``` and ```while``` statements, even when the body is empty or contains only a single statement.

    - Other optional braces, such as those in a lambda expression, remain optional.

    - Braces follow the Kernighan and Ritchie style ("Egyptian brackets") for nonempty blocks and block-like constructs:

        - No line break before the opening brace, except as detailed below.

        - Line break after the opening brace.

        - Line break before the closing brace.

        - Line break after the closing brace, only if that brace terminates a statement or terminates the body of a method, constructor, or named class. For example, there is no line break after the brace if it is followed by else or a comma.

        ```
        return () -> {
            while (condition()) {
                method();
            }
        };

        return new MyClass() {
            @Override public void method() {
                if (condition()) {
                    try {
                        something();
                    } catch (ProblemException e) {
                        recover();
                    }
                } else if (otherCondition()) {
                    somethingElse();
                } else {
                    lastThing();
                }
                {
                    int x = foo();
                    frob(x);
                }
            }
        };
        ```

    - Empty blocks may be concise:
        ```
        // This is acceptable
        void doNothing() {}

        // This is equally acceptable
        void doNothingElse() {
        }
        ```

- Block indentation: +2 spaces

- One statement per line

- Column limit: 100

- Line wrapping:

    - Where to break

        1. When a line is broken at a non-assignment operator the break comes before the symbol. 

            - This also applies to the following "operator-like" symbols:

                - the dot separator (.)

                - the two colons of a method reference (::)

                - an ampersand in a type bound (<T extends Foo & Bar>)

                - a pipe in a catch block (catch (FooException | BarException e)).

        2. When a line is broken at an assignment operator the break typically comes after the symbol, but either way is acceptable.

            - This also applies to the "assignment-operator-like" colon in an enhanced for ("foreach") statement.

        3. A method or constructor name stays attached to the open parenthesis "(" that follows it.

        4. A comma (,) stays attached to the token that precedes it.

        5. A line is never broken adjacent to the arrow in a lambda, except that a break may come immediately after the arrow if the body of the lambda consists of a single unbraced expression


    - Indent continuation lines at least +4 spaces:

        - When line-wrapping, each line after the first (each continuation line) is indented at least +4 from the original line.

        - When there are multiple continuation lines, indentation may be varied beyond +4 as desired. In general, two continuation lines use the same indentation level if and only if they begin with syntactically parallel elements.

- Horizontal whitespace
    1. Separating any reserved word, such as ```if```, ```for``` or ```catch```, from an open parenthesis (```(```) that follows it on that line

    2. Separating any reserved word, such as else or catch, from a closing curly brace (```}```) that precedes it on that line

    3. Before any open curly brace (```{```), with two exceptions:
        - ```@SomeAnnotation({a, b})``` (no space is used)

        - ```String[][] x = {{"foo"}};``` (no space is required between ```{{```)

    4. On both sides of any binary or ternary operator. This also applies to the following "operator-like" symbols:

        - the ampersand in a conjunctive type bound: ```<T extends Foo & Bar>```

        - the pipe for a catch block that handles multiple exceptions: ```catch (FooException | BarException e)```

        - the colon (```:```) in an enhanced ```for``` ("foreach") statement

        - the arrow in a lambda expression: ```(String str) -> str.length()```

        but not

        - the two colons (```::```) of a method reference, which is written like ```Object::toString```

        - the dot separator (```.```), which is written like ```object.toString()```

    5. After ```,:;``` or the closing parenthesis (```)```) of a cast

    6. Between any content and a double slash (```//```) which begins a comment. Multiple spaces are allowed.

    7. Between a double slash (```//```) which begins a comment and the comment's text. Multiple spaces are allowed.

    8. Between the type and variable of a declaration: ```List<String> list```

    9. Optional just inside both braces of an array initializer
    
        ```new int[] {5, 6} and new int[] { 5, 6 } are both valid```
    
    10. Between a type annotation and ```[]``` or ```...```.

- At the minimum, JavaDoc is present for every public class, and every public or protected member (for example, methods and variables) of such a class. JavaDoc for private class and members are strongly encouraged



## JavaScript

### Highlight

- Similar to Java

- Block indentation: +2 spaces

- Indent continuation lines at least +4 spaces

- Column limit: 100

- Braces follow the Kernighan and Ritchie style ("Egyptian brackets")

- Use horizontal whitespace before ```(``` and after ```//```

- Use test driven development

- Use ```UpperCamelCase``` for class names, use ``` lowerCamelCase``` for method and variable names, and ```UPPER_SNAKE_CASE``` for constants


### Source File Basics

- File names must be all lowercase and may include underscores (```_```) or dashes (```-```), but no additional punctuation.  Filenames’ extension must be .js

- Source files are encoded in UTF-8.

- The test class should be written piror to the production code. 


### Import Statements

- Import statements must not be line wrapped and are therefore an exception to the 100-column limit.

- The ```.js``` file extension is not optional in import paths and must always be included.

- Do not import the same file multiple times. This can make it hard to determine the aggregate imports of a file.


### Formatting

- Naming:

    - Class names are written in ```UpperCamelCase```. 
    
    - Method names, non-constant field names, parameter, and local variable names are written in ```lowerCamelCase```.

    - Constant names use ```UPPER_SNAKE_CASE```: all uppercase letters, with each word separated from the next by a single underscore

- Use of braces:

    - Braces are used with ```if```, ```else```, ```for```, ```do``` and ```while``` statements, even when the body is empty or contains only a single statement.

    - Braces follow the Kernighan and Ritchie style (Egyptian brackets) for nonempty blocks and block-like constructs:

        - No line break before the opening brace.

        - Line break after the opening brace.

        - Line break before the closing brace.

        - Line break after the closing brace if that brace terminates a statement or the body of a function or class statement, or a class method. Specifically, there is no line break after the brace if it is followed by ```else```, ```catch```, ```while```, or a comma, semicolon, or right-parenthesis.

    - Empty blocks may be concise:

    Example: 

    ```
    class InnerClass {
      constructor() {}

      /** @param {number} foo */
      method(foo) {
        if (condition(foo)) {
          try {
              // Note: this might fail.
              something();
          } catch (err) {
            recover();
          }
        }
      }
    }
    ```


