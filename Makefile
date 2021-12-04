JAVAC = javac

ART = bin

SRC = $(wildcard *.java)

OBJ := $(SRC:.java=.class)
OBJ := $(addprefix $(ART)/, $(OBJ))

JAR = DesktopBob.jar

$(shell mkdir -p $(ART))

all: $(OBJ) $(ART)/$(JAR)

$(ART)/%.class: %.java
	@echo "JAVAC   $<"
	@$(JAVAC) $< -d $(ART)

$(ART)/$(JAR): $(OBJ)
	@echo "JAR     $@"
	@./jar.sh $(ART)

run: all
	@./DesktopBob.sh

clean:
	@echo "RM      $(ART)/"
	@rm -rf $(ART)
