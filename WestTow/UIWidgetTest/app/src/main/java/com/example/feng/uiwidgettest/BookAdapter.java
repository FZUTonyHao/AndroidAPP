package com.example.feng.uiwidgettest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

class BookAdapter extends  RecyclerView.Adapter<BookAdapter.ViewHolder>{
    private List<Book> mBookList;
    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView bookImage;
        TextView bookName;


        public ViewHolder(View view) {
            super(view);
            bookImage = (ImageView) view.findViewById(R.id.book_image);
            bookName = (TextView) view.findViewById(R.id.book_name);
        }
    }

    public BookAdapter(List<Book> bookList) {
        mBookList = bookList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Book book = mBookList.get(position);

        holder.bookImage.setImageResource(book.getImageId());

        if(position%2==0){
            holder.bookName.setBackgroundResource(R.drawable.image_one);
        }
        else{
            holder.bookName.setBackgroundResource(R.drawable.image_two);
        }
        holder.bookName.setText(book.getName());
    }

    @Override
    public int getItemCount() {
        return mBookList.size();
    }

}