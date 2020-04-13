# Makefile for LeetCodeDaily
# written by hyan23
# 2019.03.03
#################################

CXX = g++
CXXFLAGS = -Wall
CPPS = $(wildcard *.cpp)
TARGETS = $(basename $(CPPS))

.PHONY: all clean

all: $(TARGETS)

%: %.cpp
	$(CXX) $(CXXFLAGS) -o $@ $<

clean:
	rm -f $(TARGETS)
