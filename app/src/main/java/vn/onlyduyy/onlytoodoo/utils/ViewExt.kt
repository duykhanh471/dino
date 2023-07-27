package vn.onlyduyy.onlytoodoo.utils

import androidx.appcompat.widget.SearchView

//important for efficiency, inline, cross-in-line -> tell the compiler
inline fun SearchView.OnQueryTextChanged(crossinline listener : (String) -> Unit) {
    this.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            //when click enter
            return true
        }
        override fun onQueryTextChange(newText: String?): Boolean {
            listener(newText.orEmpty())
            return true
        }
    })
}