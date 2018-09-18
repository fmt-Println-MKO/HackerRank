package main

import "testing"

func Test_reversePrint(t *testing.T) {

	empty := &SinglyLinkedListNode{
		next: nil,
		data: 2,
	}

	twoElem := &SinglyLinkedListNode{
		next: empty,
		data: 1,
	}
	threeElem := &SinglyLinkedListNode{
		next: twoElem,
		data: 0,
	}
	tests := []struct {
		name  string
		llist *SinglyLinkedListNode
	}{
		{"empty", empty},
		{"twoElem", twoElem},
		{"threeElem", threeElem},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			reversePrint(tt.llist)
		})
	}
}
