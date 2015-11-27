default: bin/dnaphreq bin/dnaphreq.d

bin:
	mkdir bin

bin/dnaphreq: main.c bin
	gcc main.c -fno-stack-protector -o $@
	piestrip $@

bin/dnaphreq.d: main.c bin
	gobjdump -d bin/dnaphreq > $@
