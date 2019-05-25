<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<link href="style.css" rel="stylesheet" type="text/css" />
	<link href='http://fonts.googleapis.com/css?family=Lato:400,700&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
	<link href="kurs_css3/css/fontello.css" rel="stylesheet" type="text/css" />
	<title>Strona glowna</title>
</head>
<body>
<div class="wrapper">

	<div class="header">
		<div class="logo">
			<span style="color: #c34f4f">Bash</span>ownik
			<div style="clear:both;"></div>
		</div>
	</div>
	
	<div class="nav">
		<ol>
				<li><a href="http://localhost:8080/Bashownik/">Strona glowna</a></li>
				<li><a href="http://localhost:8080/Bashownik/Login.jsp">Zaloguj</a></li>
				<li><a href="http://localhost:8080/Bashownik/Register.jsp">Rejestracja</a></li>
		</ol>
	</div>

  <center> <font color="gray" size="7"> Hello World! </font> </center>

  <div id="terminal">
    <div id="output"></div>

    <div class="input-wrap">
     $ <input id="input" type="text" autofocus />
    </div>
</div>

    <script src="bash-emulator.min.js"></script>
    <script>
      var input = document.getElementById('input')
      var output = document.getElementById('output')

      var emulator = bashEmulator({
        workingDirectory: '/',
        fileSystem: {
          '/': {
            type: 'dir',
            modified: Date.now()
          },
          '/README.txt': {
            type: 'file',
            modified: Date.now(),
            content: 'empty'
          },
          '/home': {
            type: 'dir',
            modified: Date.now()
          },
          '/home/user/journal.txt': {
            type: 'file',
            modified: Date.now(),
            content: 'this is private!'
          },
          '/home/user': {
            type: 'dir',
            modified: Date.now()
          }
        }
      })

      emulator.commands.clear = function (env) {
        output.innerHTML = ''
        env.exit()
      }

      var ENTER = 13
      var UP = 38
      var DOWN = 40

      function log (result) {
        if (result) {
          output.innerHTML += result + '\n'
        }
      }

      function error (result) {
        log('<div class="error">' + result + '</div>')
      }

      function run (cmd) {
        log('$ ' + cmd)
        return emulator.run(cmd).then(log, error)
      }

      var completeFunctions = {}
      completeFunctions[UP] = emulator.completeUp
      completeFunctions[DOWN] = emulator.completeDown

      function complete (direction) {
        var completeFunction = completeFunctions[direction]
        if (!completeFunction) {
          return
        }
        var cursorPosition = input.selectionStart
        var beforeCursor = input.value.slice(0, cursorPosition)
        completeFunction(beforeCursor).then(function (completion) {
          if (completion) {
            input.value = completion
            input.setSelectionRange(cursorPosition, cursorPosition)
          }
        })
      }

      input.addEventListener('keydown', function (e) {
        if (e.altKey || e.metaKey || e.shiftKey || e.ctrlKey) {
          return
        }
        if (e.which === UP || e.which === DOWN) {
          e.preventDefault()
          complete(e.which)
        }
      })

      input.addEventListener('keyup', function (e) {
        if (e.which !== ENTER) {
          return
        }
        run(input.value).then(function () {
          input.value = ''
          document.body.scrollTop = 10e6
        })
      })

      document.body.addEventListener('click', function () {
        // Prevent when user is selecting text
        if (!window.getSelection().isCollapsed) {
          return
        }
        input.focus()
      })

      run('pwd').then(function () {
        run('ls')
      })
    </script>

<%
    // To jest skryptlet.  Zauważ, że zmienna
    // "date" zadeklarowana w pierwszym wbudowanym
    // wyrażeniu jest dostępna również w tym późniejszym.
    System.out.println( "Test helloworld" );
    java.util.Date date = new java.util.Date();
%>
Obecnie mamy <%= date %>
</div>
</body>
</html>