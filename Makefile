JAVAC = javac

ART = bin

SRC = $(wildcard *.java)

OBJ := $(SRC:.java=.class)
OBJ := $(addprefix $(ART)/, $(OBJ))

$(shell mkdir -p $(ART))

all: $(OBJ)

$(ART)/%.class: %.java
	@echo "JAVAC $<"
	@$(JAVAC) $< -d $(ART)

clean:
	@for artifact in `find $(wildcard $(ART)/*)`; do echo "RM $$artifact"; done
	@rm -rf $(ART)
