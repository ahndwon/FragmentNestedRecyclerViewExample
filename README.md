# FragmentRecyclerView
Basic example of a **vertical** recycler view which consists of items that are fragments. 
Each fragment has a **horizontal** recycler view to show  items.

Because the vertical recycler view’s items are fragments, the code is more independent and can take advantage of being a fragment such as accessing resources, lifecycle, etc.

Also, the bottom navigation and the app bar is hidden when scrolled down to offer more screen real estate to the user.

## How Implemented
Fragments are passed to the FragmentListAdapter.
```kotlin
class FragmentListAdapter () ... {
	//...

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FragmentViewHolder {
    		val view = LayoutInflater.from(parent.context).inflate(R.layout.item_fragment, parent, false)
		// view id is changed because each view's id has to be unique in order to be replaced by the fragmentManager.
	    	view.rootView.id = viewType
    		return FragmentViewHolder(view)
	}
	
	override fun getItemViewType(position: Int): Int {
	    	return position + 1
	}

	override fun onBindViewHolder(holder: FragmentViewHolder, position: Int) {
    		fragmentManager.beginTransaction()
            		.replace(holder.itemView.id, fragments[position])
	            	.commit()
	}
	
	//...
}
```
  
The root view’s id is changed for the transaction. Because all fragments in the example is using the same layout xml. View’s id has to be unique to be replaced by fragmentManager.   
  


## Example usage
![how this example can be used](https://i.stack.imgur.com/FoXkc.png)  
This example can be used to make an UI such as above. It is a widely used UI.

## Example footage
**Recycler views**  
![](https://drive.google.com/file/d/1ScKpU05XUKJwflMxWJqZLahGjEQriao7/view)

**Bottom navigation,action bar auto hidden**   
![](https://drive.google.com/open?id=15VdJRltPc_VyxV6zczNtgyXzvuvF4kFs/view)
