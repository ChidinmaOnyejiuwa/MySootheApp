@file:OptIn(ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package com.practice.mysoothe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.practice.mysoothe.R.drawable
import com.practice.mysoothe.ui.theme.ComposeAppTheme
import java.util.Locale


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val windowSizeClass = calculateWindowSizeClass(this)
            ComposeAppTheme(windowSizeClass)
            // A surface container using the 'background' color from the theme
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SearchBar(
        modifier: Modifier = Modifier
    ) {
        TextField(
            value = "",
            onValueChange = {},
            leadingIcon = {
                Icon(
                    Icons.Default.Search,
                    contentDescription = null
                )
            },
            placeholder = {
                Text(stringResource(id = R.string.placeholder_search))
            },
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = MaterialTheme.colorScheme.surface,
                focusedIndicatorColor = MaterialTheme.colorScheme.surface,
            ),
            modifier = modifier
                .heightIn(min = 66.dp)
                .fillMaxWidth()
        )
    }

    @Composable
    fun AlignYourBodyElement(
        @DrawableRes drawable: Int,
        @StringRes text: Int,
        modifier: Modifier = Modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
        ) {
            Image(
                painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(88.dp)
                    .clip(CircleShape)
            )
            Text(
                text = stringResource(text),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .paddingFromBaseline(top = 24.dp, bottom = 8.dp)
            )
        }
    }

    @Composable
    fun FavoriteCollectionCard(
        modifier: Modifier = Modifier,
        @DrawableRes drawable: Int,
        @StringRes text: Int
    ) {
        Surface(
            shape = MaterialTheme.shapes.small,
            color = MaterialTheme.colorScheme.surfaceVariant,
            modifier = Modifier
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.width(255.dp)
            ) {
                Image(
                    painterResource(id = drawable),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(70.dp)
                )
                Text(
                    text = stringResource(text),
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

            }
        }
    }

    @Composable
    fun AlignYourBodyRow(
    ) {
        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
        ) {
            AlignYourBodyElement(
                drawable = drawable.inversion,
                text = R.string.inversion,
                modifier = Modifier.padding(8.dp)
            )
            AlignYourBodyElement(
                drawable = drawable.yoga,
                text = R.string.yoga,
                modifier = Modifier.padding(8.dp)
            )
            AlignYourBodyElement(
                drawable = drawable.stretching,
                text = R.string.stretching,
                modifier = Modifier.padding(8.dp)
            )
            AlignYourBodyElement(
                drawable = drawable.tabata,
                text = R.string.tabata,
                modifier = Modifier.padding(8.dp)
            )
            AlignYourBodyElement(
                drawable = drawable.hiit,
                text = R.string.hiit,
                modifier = Modifier.padding(8.dp)
            )
            AlignYourBodyElement(
                drawable = drawable.pre_natalyoga,
                text = R.string.Pre_natal_yoga,
                modifier = Modifier.padding(8.dp)
            )
        }
    }

    @Composable
    fun FavoriteCollectionGrid() {
        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                FavoriteCollectionCard(
                    modifier = Modifier.padding(8.dp),
                    drawable = drawable.shortmatra,
                    text = R.string.shortmantra
                )
                FavoriteCollectionCard(
                    modifier = Modifier.padding(8.dp),
                    drawable = drawable.nature,
                    text = R.string.nature_meditation
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                FavoriteCollectionCard(
                    modifier = Modifier.padding(8.dp),
                    drawable = drawable.selfmessage,
                    text = R.string.self_massage
                )
                FavoriteCollectionCard(
                    modifier = Modifier.padding(8.dp),
                    drawable = drawable.stressandanxiety,
                    text = R.string.stress_anxiety
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                FavoriteCollectionCard(
                    modifier = Modifier.padding(8.dp),
                    drawable = drawable.overwhelming,
                    text = R.string.overwhelmed
                )
                FavoriteCollectionCard(
                    modifier = Modifier.padding(8.dp),
                    drawable = drawable.nghtywinddown,
                    text = R.string.night_down
                )
            }
        }
    }

    @Composable
    fun HomeSection(
        @StringRes title: Int,
        modifier: Modifier = Modifier,
        content: @Composable () -> Unit
    ) {
        Column(modifier) {
            Text(
                text = stringResource(title).uppercase(Locale.getDefault()),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                    .padding(horizontal = 16.dp)
            )
            content()
        }
    }

    @Composable
    fun HomeScreen(
        modifier: Modifier = Modifier
    ) {
        Column(
            modifier
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(Modifier.height(16.dp))
            SearchBar(modifier.padding(horizontal = 16.dp))
            HomeSection(title = R.string.align_your_body) {
                AlignYourBodyRow()
            }
            HomeSection(title = R.string.favorite_collections) {
                FavoriteCollectionGrid()
            }
            Spacer(Modifier.height(42.dp))
        }
    }

    @Composable
    private fun SootheBottomNavigation(modifier: Modifier = Modifier) {
        NavigationBar(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            modifier = modifier
        )
        {
            NavigationBarItem(selected = true,
                onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        Icons.Default.Home,
                        contentDescription = null
                    )
                },
                label = {
                    Text(
                        stringResource
                            (id = R.string.bottom_navigation_home)
                    )
                }
            )
            NavigationBarItem(selected = false,
                onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        Icons.Default.AccountCircle,
                        contentDescription = null
                    )
                },
                label = {
                    Text(
                        stringResource
                            (id = R.string.bottom_navigation_profile)
                    )
                }
            )
        }
    }

    @Composable
    fun ComposePortrait(
    ) {
        ComposeAppTheme {
            Scaffold(
                bottomBar = { SootheBottomNavigation() }
            ) { padding ->
                HomeScreen(Modifier.padding(padding))
            }
        }
    }

    @Composable
    private fun
            NavigationRail(modifier: Modifier = Modifier) {
        NavigationRail(
            modifier = modifier.padding(start = 8.dp, end = 8.dp),
            containerColor = MaterialTheme.colorScheme.background,
        ) {
            Column(
                modifier = modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                NavigationRailItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(stringResource(R.string.bottom_navigation_home))
                    },
                    selected = true,
                    onClick = { /*TODO*/ },
                )
                Spacer(modifier = Modifier.height(8.dp))
                NavigationRailItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(stringResource(R.string.bottom_navigation_profile))
                    },
                    selected = false,
                    onClick = {}
                )
            }

        }
    }

    @Composable
    fun ComposeLandscape() {
        ComposeAppTheme {
            Surface(color = MaterialTheme.colorScheme.background) {
                Row {
                    NavigationRail()
                    HomeScreen()
                }
            }
        }
    }

    @Composable
    fun ComposeAppTheme(windowSize: WindowSizeClass) {
        when (windowSize.widthSizeClass) {
            WindowWidthSizeClass.Compact -> {
                ComposePortrait()
            }
            WindowWidthSizeClass.Expanded -> {
                ComposeLandscape()
            }
        }
    }
}





