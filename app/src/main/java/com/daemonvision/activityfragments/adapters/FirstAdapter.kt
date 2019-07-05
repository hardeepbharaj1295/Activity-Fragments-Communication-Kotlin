package com.daemonvision.activityfragments.adapters

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.daemonvision.activityfragments.R


import com.daemonvision.activityfragments.fragments.FirstFragment.OnListFragmentInteractionListener
import com.daemonvision.activityfragments.model.FirstContent.DummyItem

import kotlinx.android.synthetic.main.fragment_first.view.*


class FirstAdapter(
    private val mValues: ArrayList<DummyItem>,
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<FirstAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            Log.e("Item ",v.id.toString())
            val item = v.tag as DummyItem
//             Notify the active callbacks interface (the activity, if the fragment is attached to
//             one) that an item has been selected.
            mValues.removeAt(v.id)
            notifyDataSetChanged()
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_first, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.mIdView.text = item.id
        holder.mContentView.text = item.content

        with(holder.mIdView) {
            id = position
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView = mView.item_number
        val mContentView: TextView = mView.content

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
