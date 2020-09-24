package com.vegdev.vegacademy.presenter.recipes.recipes.parent.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vegdev.vegacademy.R
import com.vegdev.vegacademy.contract.recipes.RecipesContract
import com.vegdev.vegacademy.model.data.models.TypesRecipe
import com.vegdev.vegacademy.presenter.recipes.recipes.parent.ParentRecipesPresenter
import com.vegdev.vegacademy.presenter.recipes.recipes.single.adapter.SingleRecipeAdapter
import com.vegdev.vegacademy.utils.Utils
import kotlinx.android.synthetic.main.recipes_parent_single.view.*
import java.util.*


class ParentRecipesAdapter(
    private val iRecipesView: RecipesContract.View,
    private val types: TypesRecipe,
    private val scrollStateHolder: ScrollStateHolder
) :
    RecyclerView.Adapter<ParentRecipesViewHolder>() {

    private val adapters: MutableList<SingleRecipeAdapter> = mutableListOf()
    private val presenter = ParentRecipesPresenter(iRecipesView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentRecipesViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recipes_parent_single, parent, false)
        return ParentRecipesViewHolder(itemView, iRecipesView, scrollStateHolder)
    }

    override fun getItemCount(): Int = types.types.size

    override fun onBindViewHolder(holder: ParentRecipesViewHolder, position: Int) {
        val type: String = types.types[position]

        presenter.bindViewHolder(
            type,
            position,
            holder
        )

        holder.itemView.recipe_parent_searchbar.setOnEditorActionListener { textView, i, keyEvent ->
            holder.onParentSearchBarAction(textView.text.toString().toLowerCase(Locale.ROOT).trim())
            false
        }

        holder.itemView.recipe_parent_searchbar.setOnTouchListener(
            holder.onTouchSearchBarIcon()
        )

        holder.itemView.recipe_parent_search_icon.setOnClickListener {
            holder.showSearchBar()
        }

        holder.itemView.recipe_parent_close_searchbar.setOnClickListener {
            holder.hideSearchBar()
        }

    }
}