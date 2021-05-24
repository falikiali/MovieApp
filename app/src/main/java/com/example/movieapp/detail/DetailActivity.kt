package com.example.movieapp.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.core.domain.model.PopularMovie
import com.example.movieapp.databinding.ActivityDetailBinding
import com.google.android.material.snackbar.Snackbar
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val detailViewModel: DetailViewModel by viewModel()
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val detailPopularMovie = intent.getParcelableExtra<PopularMovie>(EXTRA_DATA)
        showDetailPopularMovie(detailPopularMovie)
    }

    private fun showDetailPopularMovie(detailPopularMovie: PopularMovie?) {
        detailPopularMovie?.let {
            supportActionBar?.title = detailPopularMovie.title
            binding.contentDetail.apply {
                tvTitleMovie.text = detailPopularMovie.title
                tvReleaseDateMovie.text = detailPopularMovie.releaseDate
                tvDescMovie.text = detailPopularMovie.desc
            }
            Glide.with(this)
                .load("https://image.tmdb.org/t/p/w600_and_h900_bestv2" + detailPopularMovie.poster)
                .into(binding.contentDetail.imageViewMovie)

            var statusFavorite = detailPopularMovie.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                if (statusFavorite) {
                    Snackbar.make(binding.root, "Removed from favorite", Snackbar.LENGTH_SHORT).setAnimationMode(Snackbar.ANIMATION_MODE_SLIDE).show()
                } else {
                    Snackbar.make(binding.root, "Add to favorite", Snackbar.LENGTH_SHORT).setAnimationMode(Snackbar.ANIMATION_MODE_SLIDE).show()
                }
                statusFavorite = !statusFavorite
                detailViewModel.setFavoritePopularMovie(detailPopularMovie, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(state: Boolean) {
        if (state) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_24))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_border_24))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}