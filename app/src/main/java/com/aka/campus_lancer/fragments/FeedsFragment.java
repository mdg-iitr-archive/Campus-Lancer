package com.aka.campus_lancer.fragments;


import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.aka.campus_lancer.BuildConfig;
import com.aka.campus_lancer.MainActivity;
import com.aka.campus_lancer.MyRecyclerViewAdapter;
import com.aka.campus_lancer.Persons;
import com.aka.campus_lancer.R;
import com.aka.campus_lancer.data.Api;
import com.aka.campus_lancer.data.model.FeedsResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author akshayaggarwal
 * @since 27-02-2016
 */
public class FeedsFragment extends Fragment {

    private MyRecyclerViewAdapter mRecyclerViewAdapter;

    private RecyclerView mRecyclerView;

    private ArrayList<Persons> feedsData = new ArrayList<>();

    public FeedsFragment() {
    }

    private Api api;

    Subscription subscription;


    public interface OnMovieSelectedListener {
        void onItemSelected(Persons persons);
    }

    OnMovieSelectedListener mCallback;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRecyclerViewAdapter = new MyRecyclerViewAdapter(feedsData);
        View rootView = inflater.inflate(R.layout.fragment_feeds, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.rv_feeds);
        //    final GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);


        sendRequest();


        return rootView;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

//    @Override
//    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
//        return new CursorLoader(getActivity(),
//                MovieContract.MovieEntry.CONTENT_URI,
//                null,
//                null,
//                null,
//                null);
//    }


    private void sendRequest() {
//        Gson gson = new GsonBuilder()
//                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
//                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://demo3488640.mockable.io/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
        Api api = retrofit.create(Api.class);
        Call<FeedsResponse> call = api.hire();
        call.enqueue(new Callback<FeedsResponse>() {
            @Override
            public void onResponse(Call<FeedsResponse> call, Response<FeedsResponse> response) {

                FeedsResponse feedsResponse = response.body();
                feedsData = new ArrayList<>(Arrays.asList(feedsResponse.getResults()));
                mRecyclerViewAdapter = new MyRecyclerViewAdapter(feedsData);
                mRecyclerView.setAdapter(mRecyclerViewAdapter);
                Log.i("response",response.toString());

            }

            @Override
            public void onFailure(Call<FeedsResponse> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });

    }


    public void itemClicked(int position) {
        mCallback.onItemSelected(feedsData.get(position));
        Toast.makeText(getActivity().getApplicationContext(), "Item cliked" + position, Toast.LENGTH_LONG).show();
    }

}




