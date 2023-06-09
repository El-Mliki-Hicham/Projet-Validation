package prototype.todolist.ui.SearshLeague

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.navigation.NavController
import com.squareup.picasso.Picasso
import prototype.todolist.R
import prototype.todolist.models.League

import prototype.todolist.ui.placeholder.PlaceholderContent.PlaceholderItem


/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class SearshLeagueAdapter(private val leagues: ArrayList<League>, navController: NavController)
    : RecyclerView.Adapter<SearshLeagueAdapter.DataViewHolder>() {

    private val navController = navController

    class DataViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        // val NameLeauge: TextView = view.findViewById<Button>(R.id.NameLeague)
        val Logo : ImageView = view.findViewById(R.id.Logo)
        val cardView: CardView = view.findViewById(R.id.cardviewLeagueItem)
        fun bind(league: League) {
//            NameLeauge.text = league.name
            Picasso.get().load(league.logo).into(Logo)
        }
    }

    // for convert league_items xml to view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.league_item, parent, false)
        return DataViewHolder(layout)
    }

    //for determine number of items shuld be displayed
    override fun getItemCount(): Int  = leagues.size



    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val league = leagues[position]
        holder.bind(league)

        holder.cardView.setOnClickListener{

            var action = SearshLeagueFragmentDirections.actionSearshLeagueFragmentToLeagueDetailsFragment(leagueId = league.id,leagueName=league.name,leagueLogo = league.logo)
            navController.navigate(action)
        }

    }

    // this methode  used for clear data in the list and add new data for displaying
    fun addLeague(leagues:List<League>) {
        this.leagues.apply {
            clear()
            addAll(leagues)
        }
    }




}