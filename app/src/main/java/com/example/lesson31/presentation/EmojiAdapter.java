package com.example.lesson31.presentation;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lesson31.databinding.ItemCardBinding;
import com.example.lesson31.domain.Card;

public class EmojiAdapter extends RecyclerView.Adapter<EmojiAdapter.EmojiViewHolder> {
    private final EmojiGame emojiGame = new EmojiGame();

    @NonNull
    @Override
    public EmojiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EmojiViewHolder(ItemCardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EmojiViewHolder holder, int position) {
        holder.onBind(emojiGame.getCards().get(position));
    }

    @Override
    public int getItemCount() {
        return emojiGame.getCards().size();
    }

    public class EmojiViewHolder extends RecyclerView.ViewHolder {
        private ItemCardBinding binding;
        public EmojiViewHolder(@NonNull ItemCardBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void onBind(Card<String> card) {
            if (card.isFaceAUp()){
                binding.itemCard.setText(card.getCardContent());
                binding.itemCard.setBackgroundColor(Color.WHITE);
            }else {
                binding.itemCard.setText("");
                binding.itemCard.setBackgroundColor(Color.BLUE);
            }
            binding.itemCard.setOnClickListener(v -> {
                emojiGame.cardClick(card, binding.getRoot().getContext());
                notifyDataSetChanged();
            });
        }
    }
}
