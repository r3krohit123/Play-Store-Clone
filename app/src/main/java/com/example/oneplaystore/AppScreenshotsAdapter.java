package com.example.oneplaystore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AppScreenshotsAdapter extends RecyclerView.Adapter<AppScreenshotsAdapter.AppViewHolder> {

    private final ArrayList<String> screenShotsList;
    private final Context mContext;

    public AppScreenshotsAdapter(ArrayList<String> screenShotsList, Context context) {
        this.screenShotsList = screenShotsList;
        this.mContext = context;

    }

    @NonNull
    @Override
    public AppViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_screenshot, parent, false);
        return new AppViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppViewHolder holder, int position) {
        Glide.with(mContext)
                .load(getImage(screenShotsList.get(position)))
                .into(holder.screenshotImage);
    }

    private int getImage(String imageName) {
        return mContext.getResources().getIdentifier(imageName, "drawable", mContext.getPackageName());
    }

    @Override
    public int getItemCount() {
        return screenShotsList.size();
    }

    class AppViewHolder extends RecyclerView.ViewHolder {

        final ImageView screenshotImage;

        AppViewHolder(View itemView) {
            super(itemView);
            screenshotImage = itemView.findViewById(R.id.iv_screenshot);
        }
    }
}
