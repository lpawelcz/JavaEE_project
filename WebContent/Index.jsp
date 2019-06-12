<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
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

  <center> <font color="gray" size="4"> <li><a href="https://www.youtube.com/watch?v=dQw4w9WgXcQ">Sprawdz</a></li> jaką dystrybucją linuxa jesteś!</font> </center>

    <% if(session.getAttribute("session") == "TRUE")
	{ %>
		<div class="nav">
			<ol>
					<li><a href="http://localhost:8080/Bashownik/Index.jsp">Strona główna</a></li>
					<li><a href="http://localhost:8080/Bashownik/Tests.jsp">Lista testów</a></li>
					<li><a href="http://localhost:8080/Bashownik/Logout.jsp">Wyloguj</a></li>
					<li><a href="http://localhost:8080/Bashownik/ViewUser.jsp">Profil</a></li>
					<li><a href="http://localhost:8080/Bashownik/CreateNewQuestion.jsp">Nowe pytania</a></li>
					<li><a href="http://localhost:8080/Bashownik/CreateNewTest.jsp">Nowe testy</a></li>
			</ol>
		</div>
	
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
          },
          '/home/test': {
            type: 'dir',
            modified: Date.now()
          },
          '/home/test/fileA.java': {
            type: 'file',
            modified: Date.now()
          },
          '/home/test/fileB.java': {
            type: 'file',
            modified: Date.now()
          },
          '/home/test/fileC.c': {
            type: 'file',
            modified: Date.now()
          },
          '/home/test/fileD.txt': {
            type: 'file',
            modified: Date.now(),
            content: 'Stefan Pirog\nPrzemyslaw Wujek\nPawel Czarnecki'
          },
          '/home/test/fileE.sh': {
            type: 'file',
            modified: Date.now(),
          }
        }
      })

      emulator.commands.echo = function (env, args){
        args.shift()
        var str = args.join(' ')
        var i
        var text = str
        for (i = 0; i < str.length; i++) { 
          text = text.replace("'", '')
          text = text.replace('"', '')
        }
        log(text)
      }

     emulator.commands.printf = function (env, args){
        args.shift()
        var str = args.join(' ')
        var i
        var text = str
        for (i = 0; i < str.length; i++) { 
          text = text.replace("'", '')
          text = text.replace('"', '')
        }
        log(text)
      }

      emulator.commands.sort = function (env, args){
        args.shift()
        var text = 'Pawel Czarnecki\nPrzemyslaw Wujek\nStefan Pirog\n'
        if(args[0] == 'fileD.txt')
          log(text)
        else
          log("Błąd\n")
      }

      emulator.commands.find = function (env, args){
        args.shift()
        var test = args.join('')
        var text = 'fileA.java fileB.java'
        if(test == ".-name'*.java'")
          log(text)
        else
          log("Błąd\n")
      }

      emulator.commands.grep = function (env, args){
        args.shift()
        var test = args.join('')
        var text = 'Przemyslaw Wujek'
        if(test == '"' + "Przemyslaw" + '"' + '"' + "fileD.txt" + '"')
          log(text)
        else
          log("Błąd\n")
      }

      emulator.commands.gcc = function (env, args){
        args.shift()
        var test = args.join('')
        var text = 'Compilation: [######] 100%'
        if(test ==  "fileC.c"){
          env.system.write('a.out', '')
          log(text)
        }
        else if(test ==  "fileC.c-ofileC"){
          env.system.write('fileC', '')
          log(text)
        }
        else
          log("Błąd\n")
      }

      emulator.commands.javac = function (env, args){
        args.shift()
        var test = args.join('')
        var text = 'Compilation: [######] 100%'
        if(test ==  "fileA.java"){
          env.system.write('fileA.class', '')
          log(text)
        }
        else
          log("Błąd\n")
      }

       emulator.commands.source = function (env, args){
        args.shift()
        var text
        if(args[0] ==  "fileE.sh"){
          text = args[1] *10
          log(text)
        }
        else
          log("Błąd\n")
      }

      emulator.commands.seq = function (env, args){
        args.shift()
        var text0 = parseInt(args[0], 10)
        var text1 = parseInt(args[1], 10)
        var text2 = parseInt(args[2], 10)
        var check = 0
        var textout
        var i = 1
        if(args.length ==  3){
          while(check < text2){
            textout = text0 + i*text1
            check = textout + text1
            i++
            log(textout)
          }        
        }
        else
          log("Błąd\n")
      }
        
      emulator.commands.whoami = function (env){
        var text = 'user'
        log(text)
      }

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
	<% } 
	else { %>
		<div class="nav">
			<ol>
					<li><a href="http://localhost:8080/Bashownik/Index.jsp">Strona główna</a></li>
					<li><a href="http://localhost:8080/Bashownik/Login.jsp">Zaloguj</a></li>
					<li><a href="http://localhost:8080/Bashownik/Register.jsp">Rejestracja</a></li>
			</ol>
		</div>
	<% } %>

<%

    java.util.Date date = new java.util.Date();
%>
Obecnie mamy <%= date %>
</div>
</body>
</html>