package com.example.productertask2.enums;

public enum PlayerPosition {
    PG{
        @Override
        public String toString() {
            return "Point Guard";
        }
    },
    SG{
        @Override
        public String toString() {
            return "Shooting Guard";
        }
    },
    SF{
        @Override
        public String toString() {
            return "Small Forward";
        }
    },
    PF{
        @Override
        public String toString() {
            return "Power Forward";
        }
    },
    C{
        @Override
        public String toString() {
            return "Center";
        }
    };
}
