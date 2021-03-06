package com.mathewsachin.fategrandautomata.core

import com.mathewsachin.fategrandautomata.core.AutomataApi.Companion.WindowRegion
import com.mathewsachin.fategrandautomata.core.GameAreaManager.Companion.GameArea

/**
 * This class is used for storing the script and image dimensions and for storing the playable area
 * in [GameArea].
 */
class GameAreaManager {
    companion object {
        /**
         * Stores either the width or height of the script dimensions. Normally, this is 1440p.
         */
        var ScriptDimension: CompareSettings? = null

        /**
         * Stores either the width or height of the image dimensions. Normally, this is 720p.
         */
        var CompareDimension: CompareSettings? = null

        private var gameArea: Region? = null

        /**
         * Stores the playable area as a [Region] in image coordinates, which is normally 720p.
         * Notches and the blue bars are excluded from this area by introducing X and Y offsets.
         */
        var GameArea: Region
            get() {
                // store the WindowRegion so we don't calculate it twice
                var windowRegion = WindowRegion;
                return gameArea?.plus(windowRegion.location) ?: windowRegion
            }
            set(value) {
                gameArea = value
            }

        /**
         * Sets all fields to null.
         */
        fun reset() {
            ScriptDimension = null
            CompareDimension = null
            gameArea = null
        }
    }
}