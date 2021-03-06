package com.supdeweb.audiodb.network.service

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.supdeweb.audiodb.model.AlbumDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumService {

    /**
     * Trending albumDtos
     */
    @GET(TRENDING_ALBUMS)
    fun getTrendingAlbums(): Call<TrendingResponse>

    /**
     *
     */
    @GET(ALBUM_DETAIL)
    fun getAlbumDetail(
        @Query("m") albumId: String,
    ): Call<GetAlbumDetailResponse>

    /**
     *
     */
    @GET(ALBUM_DETAIL)
    fun getAlbumsByArtistId(
        @Query("i") artistId: String,
    ): Call<GetAlbumDetailResponse>

    /**
     *
     */
    @GET(SEARCH_ALBUMS_BY_ARTIST)
    fun getAlbumsByArtistName(
        @Query("s") artistName: String,
    ): Call<GetAlbumDetailResponse>


    companion object {
        //ALBUM
        private const val ALBUM_DETAIL = "album.php"
        private const val TRENDING_ALBUMS = "trending.php?country=us&type=itunes&format=albums"
        private const val SEARCH_ALBUMS_BY_ARTIST = "searchalbum.php"
    }
}

data class GetAlbumDetailResponse(
    @SerializedName("album")
    @Expose
    val album: List<AlbumDto>? = null,
)
