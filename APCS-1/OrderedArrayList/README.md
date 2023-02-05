# OrderedArrayList

One of my group members asked how we would call the add() function for the NoNullsArrayList if we were overiding it, we would just call the same thing

don't write instance variables for the prior methods, you should call the superclass constructor to set those instance variables

we use compareTo method by saying that the OrderedArrayList extends Comperable, which allows us to "compare" our terms and order them.

To do the add() for the ordered ArrayList, we thought that you can just write a helper funcation that will just append the new item to the end of the Ordered arrayList then order it, then you would find the index of the item that you added and then just use the normal add() function.

The set function just needs to utilize remove(), which is a built-in ArrayList function, and then call the overridden add().

for add(index,val) in the OrderedArrayList, it has the same functionality as add(val).
