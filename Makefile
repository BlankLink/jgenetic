PACKAGE = gene
EXE = Main

all:
	javac -d bin -sourcepath src src/$(PACKAGE)/[^\#]*[^~]

clean:
	rm -rf bin/*
run:
	java -cp bin $(PACKAGE).$(EXE)
